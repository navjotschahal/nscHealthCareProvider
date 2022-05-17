package models

import formatters.TimestampFormatter
import play.api.libs.json.Json

import java.sql.Timestamp

case class ProviderServiceAndCostDetails(
                                id: String,
                                providerId: String,
                                providerName: String,
                                serviceName: String,
                                costNear: String,
                                estimatedTotalCost: String,
                                insurancePays: String,
                                estimatedOutOfPocketCost: String,
                                createdAt: Timestamp
                              )

object ProviderServiceAndCostDetails extends TimestampFormatter {
  implicit val format = Json.format[ProviderServiceAndCostDetails]
}

