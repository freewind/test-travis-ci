package controllers

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.mvc.{SimpleResult, Controller}
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent.Future
import org.apache.commons.io.FileUtils
import java.io.File

@RunWith(classOf[JUnitRunner])
class DiagnosticSpec extends Specification {

  "/diagnostic/version" should {
    "send 'no .build_version file found' if the build version file is not exist" in new WithApplication {
      val controller = new Controller with DiagnosticController with VersionFileFinder {
        override def getVersionFile = None
      }

      val version: Future[SimpleResult] = controller.version.apply(FakeRequest())
      status(version) must equalTo(OK)
      contentAsString(version) must equalTo("no .build_version file found")
    }

    "send '0.1.2.3' as version if the .build_version contains '0.1.2.3'" in new WithApplication {
      val controller = new Controller with DiagnosticController with VersionFileFinder {
        lazy val file = File.createTempFile("scala", "test")
        FileUtils.writeStringToFile(file, "0.1.2.3")
        override val getVersionFile = Some(file)
      }

      val version: Future[SimpleResult] = controller.version.apply(FakeRequest())
      status(version) must equalTo(OK)
      contentAsString(version) must equalTo("0.1.2.3")
    }
  }

}
