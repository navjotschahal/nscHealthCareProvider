package service

import models.{Provider, ProviderServiceAndCostDetails}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

trait ProviderService {

  def searchProvidersByName(
                       query: String
                     ): Future[Seq[Provider]]

  def getProviderServicesByProviderId(
                                       providerId: String
                                     ): Future[Seq[ProviderServiceAndCostDetails]]

  def getProviderById(
                       providerId: String
                     ): Future[Provider]

}

class ProviderServiceImpl @Inject()()(implicit
                                      ec: ExecutionContext
) extends ProviderService {
  override def searchProvidersByName(query: String): Future[Seq[Provider]] = ???

  override def getProviderServicesByProviderId(providerId: String): Future[Seq[ProviderServiceAndCostDetails]] = ???

  override def getProviderById(providerId: String): Future[Provider] = ???
}
