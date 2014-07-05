package controllers

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.libs.json.Json
import play.api.mvc.AnyContentAsJson
import play.api.test._
import play.api.test.FakeHeaders
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "render the index page" in new WithApplication {
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain("Your new application is ready.")
    }
  }

  "Application" should {
    "send a welcome json with the name I posted" in new WithApplication {
      val hello = route(FakeRequest(POST, "/hello", FakeHeaders(), AnyContentAsJson(Json.obj("name" -> "scala_workshop")))).get
      status(hello) must equalTo(OK)
      contentType(hello) must beSome("application/json")
      contentAsString(hello) must equalTo( """{"scala_workshop":"welcome"}""")
    }
  }

}
