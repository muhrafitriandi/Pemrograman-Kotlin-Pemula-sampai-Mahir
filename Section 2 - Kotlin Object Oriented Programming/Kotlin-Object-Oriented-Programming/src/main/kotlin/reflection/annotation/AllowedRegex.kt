package reflection.annotation

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME) // the default is runtime
@MustBeDocumented
annotation class AllowedRegex(val regex: String)