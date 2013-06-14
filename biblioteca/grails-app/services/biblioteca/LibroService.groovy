package biblioteca

class LibroService {

	def obtenerLibros(autorId){
		if (!autorId.isLong()) {
			//el id del autor tiene que ser numerico
			return null
		}
		def autor = Autor.get(autorId)
		if (autor?.libros){
			autor.libros.collect{[titulo:it.titulo, genero:it.genero]}
		} else {
			[]
		}
	}
	
    def crearLibro(titulo, genero, fechaPublicacion) {
		
		if (!titulo || !genero) {
			//titulo y genero son obligatorios
			return 'titulo y genero son atributos obligatorios'
		}
		
		def fechaPublicacionDate = null
		if (fechaPublicacion) {
			//reviso que tenga un formato valido
			try {
				fechaPublicacionDate = Date.parse("yyyy-MM-dd", fechaPublicacion)
			} catch (Exception e) {
				//si hubo error, es porque no es un formato valido
				return "fecha_publicacion esta en un formato invalido. formato valido: YYYY-MM-DD"
			}
		}
		
		def libro = new Libro (titulo:titulo, genero:genero)
		if (fechaPublicacionDate) {
			libro.fechaPublicacion = fechaPublicacionDate
		} else {
			libro.fechaPublicacion = null
		}
		
		if (!libro.validate()) {
			//no pasaron las validaciones
			return [error:true, errorList:libro.errors]
		}
		
		libro.save()
		
		[id: libro.id, titulo:libro.titulo, genero:libro.genero,
			fecha_publicacion: libro.fechaPublicacion ? libro.fechaPublicacion.format('yyyy-MM-dd') : null
		]

    }
}
