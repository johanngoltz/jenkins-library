import groovy.transform.Field

@Field String STEP_NAME = getClass().getName()
@Field String METADATA_FILE = ""

void call(Map parameters = [:]) {
    // List credentials = [
    //     [type: 'usernamePassword', id: 'checkIfStepActiveCredentialsId', env: ['PIPER_username', 'PIPER_password']]
    // ]
    //piperExecuteBin(parameters, STEP_NAME, METADATA_FILE, [])
    String piperGoPath = parameters.piperGoPath ?: './piper'
    String stageConfig = parameters.stageConfig
    String stageOutputFile = parameters.stageOutputFile
    script.sh(returnStdout: true, script: "${piperGoPath} checkIfStepActive --stageConfig ${stageConfig} --useV1 --stageOutputFile ${stageOutputFile}")
}