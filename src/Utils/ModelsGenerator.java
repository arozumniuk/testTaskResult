package Utils;


import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ModelsGenerator {

    private static void generateModels(File sourceFile, String targetPackage) throws IOException {
        JCodeModel codeModel = new JCodeModel();
        URL source = new URL("file:///" + sourceFile.getAbsolutePath());

        GenerationConfig config = new DefaultGenerationConfig() {

            @Override
            public boolean isRemoveOldOutput() {
                return true;
            }

            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public AnnotationStyle getAnnotationStyle() {
                return AnnotationStyle.JACKSON2;
            }

            @Override
            public SourceType getSourceType() {
                return SourceType.JSONSCHEMA;
            }

            @Override
            public boolean isIncludeAdditionalProperties() {
                return false;
            }


        };

        String className = sourceFile.getName();
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config) {
        }, new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, className, targetPackage, source);

        codeModel.build(new File("./src/"));
    }

    public static void generateDTOs(String sourceDirectory, String targetPackage) throws IOException {

        try {
            //takes all files from directory
            File[] filesNames = new File(sourceDirectory).listFiles();

            for (File file : filesNames) {
                targetPackage = targetPackage + "." + file.getName();
                generateModels(file, targetPackage);
            }
        } catch (NullPointerException ex) {
            Logger.ERROR("\n" + sourceDirectory + "do not contains files");
        }
    }

    public static void main(String[] args) throws IOException {
        generateDTOs("src/resources/jsonSchemas", "POM.Pojo");
    }

}
