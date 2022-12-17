
import yaml

configPath = 'config.yaml'
profileKey = "profile"
def getProfile() -> str:
    return getConfigByKey(profileKey)
def getConfigByKey(key):
    return getAllConfig()[key]
def getAllConfig() -> dict:
    allConfigs = {}
    with open(configPath, 'r') as config:
        allConfigs.update(yaml.safe_load(config))
        currentProfile = allConfigs[profileKey]
        profileConfigPath = './config-{}.yaml'.format(currentProfile)
        with open(profileConfigPath, 'r') as currentProfileConfig:
            allConfigs.update(yaml.safe_load(currentProfileConfig))
    return allConfigs
