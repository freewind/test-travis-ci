package controllers

import play.api.mvc._
import play.api.Play
import org.apache.commons.io.FileUtils
import java.io.File

object Diagnostic extends Controller with DiagnosticController with VersionFileFinder {
  override def getVersionFile = Some(Play.current.getFile(".build_version")).filter(_.isFile)
}


trait DiagnosticController {
  this: Controller with VersionFileFinder =>

  def version = Action {
    Ok(readVersion)
  }

  private def readVersion = getVersionFile.fold("no .build_version file found")(FileUtils.readFileToString)

}

trait VersionFileFinder {
  def getVersionFile: Option[File]
}
