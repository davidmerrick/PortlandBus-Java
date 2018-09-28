package com.merricklabs.portlandbus

import org.koin.standalone.KoinComponent

class PortlandBusConfig : KoinComponent {

    val trimet = Trimet()
    val alexa = Alexa()
    val dynamoDb = DynamoDb()

    inner class Trimet {
        val appId = System.getenv("TRIMET_APP_ID")
        val arrivalsEndpoint = "https://developer.trimet.org/ws/V1/arrivals"
    }

    inner class Alexa {
        val skillId: String = System.getenv("SKILL_ID")
        val invocationName: String = System.getenv("INVOCATION_NAME")
        val stopIdSlot = "stopId"
    }

    inner class DynamoDb {
        val endpoint: String = if (System.getenv("DYNAMODB_ENDPOINT") != null)
            System.getenv("DYNAMODB_ENDPOINT")
        else
            "https://dynamodb.us-west-2.amazonaws.com"
        val region: String = if (System.getenv("DYNAMODB_REGION") != null)
            System.getenv("DYNAMODB_REGION")
        else
            "us-west-2"
        val tableName: String = System.getenv("DYNAMODB_TABLE")
        val userIdKey = "UserId"
        val stopIdKey = "StopId"
    }
}