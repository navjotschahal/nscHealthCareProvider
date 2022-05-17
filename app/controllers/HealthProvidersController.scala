package controllers

import play.api.libs.json.Json
import play.api.mvc._

import javax.inject._
import scala.concurrent.ExecutionContext
import models.Provider
import play.api.Logging
import service.ProviderServiceImpl

import scala.util.{Failure, Success}

@Singleton
class HealthProvidersController @Inject() (
    controllerComponents: ControllerComponents,
    providerServiceImpl: ProviderServiceImpl
)(implicit
    ec: ExecutionContext
) extends AbstractController(controllerComponents = controllerComponents) with Logging {

  def searchProviders(
      query: String
  ): EssentialAction = Action.async {
    providerServiceImpl
      .searchProvidersByName(query)
      .andThen {
      case Failure(t) => logger.error("Logging DB failure while fetching providers. :", t)
      case Success(v) => logger.info(s"Successfully found providers in DB : ${v}")
    }.map(providers => {
      val providersData = Json.toJson(providers)
      logger.info(s"Successfully returning providers data : ${providersData.toString()}")
      Ok(providersData)
    })
  }

  def getSelectedProviderDetails(
      id: String
  ): EssentialAction = ???

  def getProviderById(
      providerId: String
  ): EssentialAction = ???

}
