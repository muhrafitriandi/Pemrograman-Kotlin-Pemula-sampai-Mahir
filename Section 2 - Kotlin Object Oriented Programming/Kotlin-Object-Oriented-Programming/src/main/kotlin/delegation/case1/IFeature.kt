package delegation.case1

interface IFeature {
    fun detection(woundType: String)

    fun browser(name: String)

}

class DeveloperAndroid : IFeature {
    override fun detection(woundType: String) {
        println("Detection Result with Pixel Camera: $woundType")
    }

    override fun browser(name: String) {
        println("Open Browser with $name")
    }

}

class DeveloperIOS : IFeature {
    override fun detection(woundType: String) {
        println("Detection with Smart Camera: $woundType")
    }

    override fun browser(name: String) {
        println("Open Browser with $name")
    }

}

class Client(val developer: IFeature) : IFeature by developer