package es.ctrlz.twember

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

@Secured(["isAuthenticated()"])
class MessageController {

	def springSecurityService

    def index() {
		render Message.findAll() as JSON
	}

	def show() {
		def message = Message.get(params.id)
		if (message) {
			render message as JSON
		} else {
			def result = [result: 'Message not found']
			render result as JSON
		}
	}

	def update(MessageCommand cmd) {
		if (cmd.validate()) {
			def message = Message.get(params.id)
			if (message) {
				if (message.user.id == springSecurityService.currentUser.id) {
					message.body = cmd.body
					message.save(failOnError: true)
					render message as JSON
				} else {
					def result = [result: 'You are not the owner of this message']
					render result as JSON
				}
			} else {
				def result = [result: 'Message not found']
				render result as JSON
			}
		} else {
			def result = [result: 'Invalid message']
			render result as JSON
		}
	}

	def save(MessageCommand cmd) {
		if (cmd.validate()) {
			def message = new Message(body: cmd.body)
			springSecurityService.currentUser.addToMessages(message).save(failOnError: true)
			render message as JSON
		} else {
			def result = [result: 'Invalid message']
			render result as JSON
		}
	}

	def delete() {
		def message = Message.get(params.id)
		if (message) {
			if (message.user.id == springSecurityService.currentUser.id) {
				message.delete()
				def result = [result: 'Message correctly deleted']
				render result as JSON
			} else {
				def result = [result: 'You are not the owner of this message']
				render result as JSON
			}
		} else {
			def result = [result: 'Message not found']
			render result as JSON
		}
	}


	class MessageCommand {
		String body

		static constraints = {
			body blank: false
		}
	}

}
