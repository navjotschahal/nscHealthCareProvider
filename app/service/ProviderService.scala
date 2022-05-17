package service

import dao.ProvidersDao
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
                     ): Future[Seq[Provider]]

}

class ProviderServiceImpl @Inject()(providersDao: ProvidersDao)(implicit
                                      ec: ExecutionContext
) extends ProviderService {
  override def searchProvidersByName(query: String): Future[Seq[Provider]] = providersDao.searchProviders(query)

  override def getProviderServicesByProviderId(providerId: String): Future[Seq[ProviderServiceAndCostDetails]] = providersDao.getProviderServicesByProviderId(providerId)

  override def getProviderById(providerId: String): Future[Seq[Provider]] = providersDao.getProviderById(providerId)
}
