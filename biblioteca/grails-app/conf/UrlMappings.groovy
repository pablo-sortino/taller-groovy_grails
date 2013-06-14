class UrlMappings {

	static mappings = {
		"/api/ping" (
			controller: "api",
			action: [GET: "ping"]
		)
		
		"/api/autores/$id" (
			controller: "api",
			action: [GET: "getAutor"]
		)
		
		"/api/autores/$id/libros" (
			controller: "api",
			action: [GET: "getLibrosXAutor"]
		)
		
		"/api/libros" (
			controller: "api",
			action: [POST: "postLibro"]
		)

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
