import es.ctrlz.twember.*

class BootStrap {

    def init = { servletContext ->
		def user = new User(
			username: 'test',
			password: 'test',
			enabled: true
		)

		5.times {
			user.addToMessages(new Message(body: "Mensage ${it} de prueba"))
		}

		user.save(failOnError: true)
    }

    def destroy = {
    }
}
