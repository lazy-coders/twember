package es.ctrlz.twember

class Message {

	String body
	Date dateCreated
	
	static belongsTo = [user: User]

    static constraints = {
    }
}
