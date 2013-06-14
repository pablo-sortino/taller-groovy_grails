package biblioteca

import grails.converters.JSON


class ApiController {

	def libroService
	def autorService
	
    def ping() {
		render 'pong'
	}
	
	def getAutor() {
		def autorMap = autorService.obtenerAutor(params.id)
		response.contentType = 'application/json'
		response.status = autorMap ? 200 : 404
		render autorMap? (autorMap as JSON) : ([:] as JSON)
	}
	
	def getLibrosXAutor() {
		response.contentType = 'application/json'
		def libros = libroService.obtenerLibros(params.id)
		if (libros) {
			response.status = 200
			render (libros as JSON) 
		} else {
			response.status = 404
			render ([:] as JSON)
		}
	}
	
	def postLibro () {
		response.contentType = 'application/json'
		
		def json = [:]
		try {
			json = request.getJSON()
		} catch ( Exception e ) {
			response.status = 400
			render ([message:'invalid Json format']) as JSON
			return
		}
		
		if (!json.titulo || !json.genero) {
			response.status = 400
			render ([message:'titulo y genero son atributos obligatorios']) as JSON
			return
		}
		
		def libro = libroService.crearLibro(json.titulo, json.genero, json.fecha_publicacion)
		if (libro.error) {
			response.status = 400
			render ([message:'Hubo un error guardando el libro', lista_errores:libro.errorList]) as JSON
		} else {
			response.status = 200
			render libro as JSON
		}
	}

}
