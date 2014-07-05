package controllers

import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def hello = Action(parse.text) { request =>
    val content = request.body
    val name = Json.parse(content) \ "name"
    Ok( s"""{$name:"welcome"}""").as("application/json")
  }

}
