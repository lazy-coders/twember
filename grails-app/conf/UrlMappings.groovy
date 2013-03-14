class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/api/messages"(controller: "message", action: "index", parseRequest: true)
		"/api/message/$id?"(resource: "message")

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
