package live.groupstudy.annotation_processors

import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider

class CustomAnnotationProvider: SymbolProcessorProvider{
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return CustomAnnotationProcessor(environment.codeGenerator,
            environment.logger,
            environment.options)
    }
}