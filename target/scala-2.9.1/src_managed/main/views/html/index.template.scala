
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("Welcome to Play 2.0")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""
    
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<title>"""),_display_(Seq[Any](/*8.11*/message)),format.raw/*8.18*/("""</title>
		
		<link rel='stylesheet' type='text/css' href='reset.css' />
	    <!--
		<link rel='stylesheet' type='text/css' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css' />
		-->

    <link rel='stylesheet' type='text/css' href=""""),_display_(Seq[Any](/*15.51*/routes/*15.57*/.Assets.at)),format.raw/*15.67*/(""" ( "jquery-week-calendar/libs/css/smoothness/jquery-ui-1.8.11.custom.css" )" />

	  <link rel="stylesheet" type="text/css" href="../skins/default.css" />

		<link rel='stylesheet' type='text/css' href='../jquery.weekcalendar.css' />
		<link rel='stylesheet' type='text/css' href='demo.css' />
									
		<link rel='stylesheet' type='text/css' href='../skins/default.css' />


		   <!--
		<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js'></script>
	    <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js'></script>
	    -->
    
	   <script type='text/javascript' src='../libs/jquery-1.4.4.min.js'></script>
	    <script type='text/javascript' src='../libs/jquery-ui-1.8.11.custom.min.js'></script>
	<!-- 	<script type="text/javascript" src="http://jqueryui.com/themeroller/themeswitchertool/"></script> -->
	  <script>
		  $(document).ready(function()"""),format.raw("""{"""),format.raw/*34.34*/("""
		   // $('#switcher').themeswitcher();
		  """),format.raw("""}"""),format.raw/*36.6*/(""");
 		 </script>
	 	<script type="text/javascript" src="../libs/date.js"></script>
	 	<script type='text/javascript' src='../jquery.weekcalendar.js'></script>
	 	<script type='text/javascript' src='demo.js'></script>
	</head>
	<body>
		
	</body>
    
""")))})))}
    }
    
    def render(message:String) = apply(message)
    
    def f:((String) => play.api.templates.Html) = (message) => apply(message)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jan 26 12:38:22 GMT 2013
                    SOURCE: /Users/tbm/Desktop/BBintegra/app/views/index.scala.html
                    HASH: 3f26e32ce0f3988358460efb45f1b56e36559c6f
                    MATRIX: 755->1|849->18|886->21|921->48|960->50|1131->186|1159->193|1464->462|1479->468|1511->478|2517->1437|2609->1483
                    LINES: 27->1|30->1|32->3|32->3|32->3|37->8|37->8|44->15|44->15|44->15|63->34|65->36
                    -- GENERATED --
                */
            