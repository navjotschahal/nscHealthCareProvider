package controllers

import play.api.mvc._

import javax.inject._
import scala.concurrent.ExecutionContext


@Singleton
class HealthProvidersController @Inject()(controllerComponents: ControllerComponents)(implicit
                                                                                      ec: ExecutionContext
)  extends AbstractController(controllerComponents = controllerComponents) {

  def searchProviders(
                       searchText: String
                     ): EssentialAction = ???

  def getSelectedProviderDetails(
                                  id: String
                                ): EssentialAction = ???

  def getProviderById(
                       providerId: String
                     ): EssentialAction = ???


}
