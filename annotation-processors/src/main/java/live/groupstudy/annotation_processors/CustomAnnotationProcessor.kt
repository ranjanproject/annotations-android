package live.groupstudy.annotation_processors

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSTypeArgument
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.google.devtools.ksp.validate
import java.io.OutputStream

class CustomAnnotationProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger,
    private val options: Map<String, String>
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation("CustomAnnotation") .filterIsInstance<KSClassDeclaration>()

        val file: OutputStream = codeGenerator.createNewFile(
            // Make sure to associate the generated file with sources to keep/maintain it across incremental builds.
            // Learn more about incremental processing in KSP from the official docs:
            // https://kotlinlang.org/docs/ksp-incremental.html
            dependencies = Dependencies(false, *resolver.getAllFiles().toList().toTypedArray()),
            packageName = "live.groupstudy",
            fileName = "GeneratedCustom"
        )


        file += "package live.groupstudy\n"

        symbols.forEach { it.accept(Visitor(file), Unit) }

        file.close()
        val unableToProcess = symbols.filterNot { it.validate() }.toList()
        return unableToProcess


    }

    operator fun OutputStream.plusAssign(str: String) {
        this.write(str.toByteArray())
    }

    inner class Visitor(private val file: OutputStream): KSVisitorVoid(){
        override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
        }

        override fun visitPropertyDeclaration(property: KSPropertyDeclaration, data: Unit) {
        }

        override fun visitTypeArgument(typeArgument: KSTypeArgument, data: Unit) {
        }
    }
}