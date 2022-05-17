package models

import play.api.libs.json.Json

case class ProviderServiceAndCostDetails(
                                id: String,
                                providerId: String,
                                providerName: String,
                                serviceName: String,
                                costNear: String,
                                estimatedTotalCost: String,
                                insurancePays: String,
                                estimatedOutOfPocketCost: String,
                              )

object ProviderServiceAndCostDetails {
  implicit val format = Json.format[ProviderServiceAndCostDetails]
}

