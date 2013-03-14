modules = {
    application {
        resource url:'js/application.js'
    }

	ember {
		dependsOn 'jquery'
		resource url:'js/handlebars/handlebars.js'
		resource url:'js/emberjs/ember-1.0.0-rc.1.js'
	}
}
