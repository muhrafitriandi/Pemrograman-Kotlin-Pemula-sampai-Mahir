package annotation_target

@Target(
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.FIELD,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Beta

class ExampleTarget(
    @get:Beta val firstName: String,
    @field:Beta val middleName: String,
    @param:Beta val lastName: String
)