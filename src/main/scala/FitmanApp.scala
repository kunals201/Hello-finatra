import com.twitter.finagle.http.Request
import com.twitter.finatra.HttpServer
import com.twitter.finatra.http.Controller
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter

object HelloApp extends HelloServer

class HelloServer extends HttpServer {
  override protected def configureHttp(router: HttpRouter): Unit = {

    router
      .filter[CommonFilters]
      .add[HelloController]
  }
}

class HelloController extends Controller {

  get("/hello") { request: Request =>
    "Finatra says hello :)..."
  }

}



