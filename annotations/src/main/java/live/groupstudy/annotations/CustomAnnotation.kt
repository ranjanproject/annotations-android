package live.groupstudy.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class CustomAnnotation(val name: String)
