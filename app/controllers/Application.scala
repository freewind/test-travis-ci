package controllers

import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def hello = Action(parse.json) { request =>
    val name = request.body \ "name"
    val json = Json.obj(name.as[String] -> "welcome")
    Ok(json)
  }

}
