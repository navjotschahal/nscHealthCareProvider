package dao

import database.schema.ProvidersTable
import models.Provider
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.ControllerComponents
import play.db.NamedDatabase
import slick.jdbc.JdbcProfile

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ProvidersDao @Inject()(@NamedDatabase("hcp") protected val dbConfigProvider: DatabaseConfigProvider, cc: ControllerComponents)(implicit ec: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  val providersTable = TableQuery[ProvidersTable]

  def searchProviders(
                       searchText: String
                     ): Future[Seq[Provider]] = {
    val query = providersTable
      .filter(row => row.name.toLowerCase.like(s"%${searchText.toLowerCase}%"))
      .result
    db.run(query)
  }
}
