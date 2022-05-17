package models

import play.api.libs.json.Json

case class Provider(
  id: String,
  name: String,
  specialization: String,
  address: String,
  phone: String,
)

object Provider {
  implicit val providerFormat = Json.format[Provider]
}