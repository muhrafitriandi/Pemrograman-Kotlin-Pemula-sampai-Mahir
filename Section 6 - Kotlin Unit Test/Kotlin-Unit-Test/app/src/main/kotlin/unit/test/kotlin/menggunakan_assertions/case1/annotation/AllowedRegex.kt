package unit.test.kotlin.menggunakan_assertions.case1.annotation

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class AllowedRegex(val regex: String)
