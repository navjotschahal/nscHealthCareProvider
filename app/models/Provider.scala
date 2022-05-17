package models

import play.api.libs.json.Json

import java.sql.Timestamp
import java.util.Date
import formatters.TimestampFormatter

/** Provider entity model for hcp app.
  * @param id
  * @param name
  * @param specialization
  * @param address
  * @param phone
  * @param createdAt
  */
case class Provider(
    id: String,
    name: String,
    specialization: String,
    address: String,
    phone: String,
    createdAt: Timestamp = new Timestamp((new Date()).getTime())
)

object Provider extends TimestampFormatter {
  implicit val providerFormat = Json.format[Provider]
}
