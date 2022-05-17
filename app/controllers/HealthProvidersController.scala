package controllers

import play.api.libs.json.Json
import play.api.mvc._

import javax.inject._
import scala.concurrent.ExecutionContext
import play.api.Logging
import service.ProviderServiceImpl

import scala.util.{Failure, Success}

/**
 * Controller for Provider api's.
 * @param controllerComponents
 * @param providerServiceImpl
 * @param ec
 */
@Singleton
class HealthProvidersController @Inject() (
    controllerComponents: ControllerComponents,
    providerServiceImpl: ProviderServiceImpl
)(implicit
    ec: ExecutionContext
) extends AbstractController(controllerComponents = controllerComponents)
    with Logging {

  def searchProviders(
      query: String
  ): EssentialAction = Action.async {
    providerServiceImpl
      .searchProvidersByName(query)
      .andThen {
        case Failure(t) =>
          logger.error("Logging DB failure while fetching providers. :", t)
        case Success(v) =>
          logger.info(s"Successfully found providers in DB : ${v}")
      }
      .map(providers => {
        val providersData = Json.toJson(providers)
        logger.info(
          s"Successfully returning providers data : ${providersData.toString()}"
        )
        Ok(providersData)
      })
  }

  def getSelectedProviderServiceDetails(
      id: String
  ): EssentialAction = Action.async {
    providerServiceImpl
      .getProviderServicesByProviderId(id)
      .andThen {
        case Failure(t) =>
          logger.error(
            "Logging DB failure while fetching provider services. :",
            t
          )
        case Success(v) =>
          logger.info(s"Successfully found provider services in DB : ${v}")
      }
      .map(providers => {
        val providersData = Json.toJson(providers)
        logger.info(
          s"Successfully returning provider services and cost data sequence : ${providersData.toString()}"
        )
        Ok(providersData)
      })
  }

  def getProviderById(
      providerId: String
  ): EssentialAction = Action.async {
    providerServiceImpl
      .getProviderById(providerId)
      .andThen {
        case Failure(t) =>
          logger.error("Logging DB failure while fetching providers. :", t)
        case Success(v) =>
          logger.info(s"Successfully found providers in DB : ${v}")
      }
      .map(providers => {
        val providersData = Json.toJson(providers)
        logger.info(
          s"Successfully returning providers data : ${providersData.toString()}"
        )
        Ok(providersData)
      })
  }

}
