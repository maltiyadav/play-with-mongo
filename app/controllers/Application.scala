package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import model.Domain.FormName
import scala.concurrent.Future
import reactivemongo.api._
import reactivemongo.bson._

import model.QueryBuilder._

object Application extends Controller {
  /*
 * formName 
 */
  val formName = Form(
    mapping(
      "name" -> nonEmptyText)(FormName.apply)(FormName.unapply))

  def index = Action {
    Ok(views.html.index(formName))
  }

  def submitform = Action { implicit request =>
    formName.bindFromRequest.fold(
      error => BadRequest(views.html.index(error)),
      formName => {
        val document = BSONDocument(
          "name" -> formName.name)
         inserDocument(document) 
          
        Ok("zdrg")
      })
  }

}