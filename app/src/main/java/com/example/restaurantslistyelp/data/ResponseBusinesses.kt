package com.example.restaurantslistyelp.data

class Category {
    var alias: String? = null
    var title: String? = null
}

class Coordinates {
    var latitude = 0.0
    var longitude = 0.0
}

class Location {
    var address1: String? = null
    var address2: String? = null
    var address3: String? = null
    var city: String? = null
    var zip_code: String? = null
    var country: String? = null
    var state: String? = null
    var display_address: ArrayList<String>? = null
}

class Business {
    var id: String? = null
    var alias: String? = null
    var name: String? = null
    var image_url: String? = null
    var is_closed = false
    var url: String? = null
    var review_count = 0
    var categories: ArrayList<Category>? = null
    var rating = 0.0
    var coordinates: Coordinates? = null
    var transactions: ArrayList<String>? = null
    var price: String? = null
    var location: Location? = null
    var phone: String? = null
    var display_phone: String? = null
    var distance = 0.0
}

class Center {
    var longitude = 0.0
    var latitude = 0.0
}

class Region {
    var center: Center? = null
}

class ResponseBusinesses {
    var businesses: ArrayList<Business>? = null
    var total = 0
    var region: Region? = null
}
