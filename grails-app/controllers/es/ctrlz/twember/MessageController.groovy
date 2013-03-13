package es.ctrlz.twember

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

@Secured(["isAuthenticated()"])
class MessageController {

    def index() {
		render Message.findAll() as JSON
	}

	def show() {}

	def update() {}

	def save() {}

	def delete() {}
}
