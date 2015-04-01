package model

import utils.Connection
import utils.Connection._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import reactivemongo.bson._
object QueryBuilder {

  def inserDocument(document : BSONDocument){
    personColl.insert(document)
  }
}