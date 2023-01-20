package reflection

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME) // the default is runtime
@MustBeDocumented
annotation class NotBlank
