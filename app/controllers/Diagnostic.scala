package controllers

import play.api.mvc._
import play.api.Play
import org.apache.commons.io.FileUtils
import java.io.File
import play.api.libs.json.Json

object Diagnostic extends Controller with DiagnosticController with VersionFileFinder {
  override def getVersionFile = Some(Play.current.getFile("conf/.build_version")).filter(_.isFile)
}


trait DiagnosticController {
  this: Controller with VersionFileFinder =>

  def version = Action {
    Ok(readVersion)
  }

  def paths = Action {
    Ok(Json.obj("play.current.path" -> Play.current.path.getAbsolutePath,
      """play.getFile(".")""" -> Play.current.getFile(".").getAbsolutePath,
      ".build_version" -> Play.current.getFile("conf/.build_version").getAbsolutePath
    ))
  }

  private def readVersion = getVersionFile.fold("no .build_version file found")(FileUtils.readFileToString)

}

trait VersionFileFinder {
  def getVersionFile: Option[File]
}
