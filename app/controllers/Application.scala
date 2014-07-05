package controllers

import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def hello = Action(parse.json) { request =>
    request.body.validate[HelloName].asOpt match {
      case Some(HelloName(name)) => Ok(Json.obj(name -> "welcome"))
      case _ => BadRequest
    }
  }

  case class HelloName(name: String)

  implicit val helloNameReads = Json.reads[HelloName]

}
