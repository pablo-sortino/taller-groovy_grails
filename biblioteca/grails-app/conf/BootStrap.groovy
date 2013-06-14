import biblioteca.Autor;
import biblioteca.Libro;

class BootStrap {

    def init = { servletContext ->
		
		// ----- Autor 1 -----
		
		def libro1 = new Libro()
		libro1.titulo = 'Groovy in Action'
		libro1.genero = 'programacion'
		libro1.fechaPublicacion = Date.parse("yyyy-M-d", "2012-01-15")
		if (libro1.save()) {
			println "Cargado $libro1"
		} 
		
		def autor1 = new Autor()
		autor1.nombre = 'Guillaume Laforge'
		autor1.nacionalidad = 'francia'
		autor1.libros = [autor1]
		if (autor1.save()) {
			println "Cargado $autor1"
		}
		
		// ----- Autor 2 -----
		
		def libro2 = new Libro(titulo:'El principito', genero:'infantiles', fechaPublicacion:Date.parse("yyyy-M-d", "1943-01-01"))
		if (libro2.save()) {
			println "Cargado $libro2"
		}
		
		def autor2 = new Autor(nombre:'Antoine de Saint-Exupery', nacionalidad:'francia')
		autor2.libros = [libro2]
		if (autor2.save()) {
			println "Cargado $autor2"
		}
		
		
		
		// ----- Autor 3 ----- 
		
		def libro3 = new Libro(titulo:'Los piratas de los asteroides', genero:'ciencia ficcion', fechaPublicacion:Date.parse("yyyy-M-d", "1953-01-01"))
		if (libro3.save()) {
			println "Cargado $libro3"
		}
		
		def libro4 = new Libro(titulo:'Yo Robot', genero:'ciencia ficcion', fechaPublicacion:Date.parse("yyyy-M-d", "1950-06-18"))
		if (libro4.save()) {
			println "Cargado $libro4"
		}
		
		def libro5 = new Libro(titulo:'Anochecer', genero:'ciencia ficcion', fechaPublicacion:Date.parse("yyyy-M-d", "1990-14-12"))
		if (libro5.save()) {
			println "Cargado $libro5"
		}
		
		def autor3 = new Autor(nombre:'Isaac Asimov', nacionalidad:'estados unidos')
		autor3.libros = [libro3,libro4,libro5]
		if (autor3.save()) {
			println "Cargado $autor3"
		}
    }
	
    def destroy = {
    }
}
