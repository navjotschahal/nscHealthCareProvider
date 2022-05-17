package models

import formatters.TimestampFormatter
import play.api.libs.json.Json

import java.sql.Timestamp

/** Provider Services and cost details model entity for hcp app.
  * @param id
  * @param providerId
  * @param providerName
  * @param serviceName
  * @param costNear
  * @param estimatedTotalCost
  * @param insurancePays
  * @param estimatedOutOfPocketCost
  * @param createdAt
  */
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
