# ContextQuickie.TeamProvider
This Eclipse plugin provides a TortoiseSVN based team provider which forwards the following Eclipse operations to the working copy:
- Adding new files
- Copying files
- Moving files

Starting with version 0.4.0, it is possible to export and import projects sets which can be e.g. used for automatic deployment with Eclipse Oomph. A detailed description of the project set file format can be found here.

To use ContextQuickie.Teamprovider one of the following TortoiseSVN versions must be installed:
- 1.9.x
- 1.10.x
- 1.11.x
- 1.12.x
- 1.13.x
- 1.14.x

Remarks:

TortoiseSVN versions 1.8.x and below cannot be used because the JavaHL libraries of this versions don't provide the required APIs.
If you're using a 64bit version of eclipse you also need the 64bit version of TortoiseSVN. Same for the 32bit version. Mixing architectures doesn't work.

# Screenshots

## ContextQuickie.TeamProvider Entry when sharing a Project

![ContextQuickie.TeamProvider Entry when sharing a Project](https://github.com/RolandoMagico/ContextQuickie.TeamProvider/raw/main/Images/ShareProject.png)

## ContextQuickie.TeamProvider Summary when sharing a Project

![ContextQuickie.TeamProvider Entry when sharing a Project](https://github.com/RolandoMagico/ContextQuickie.TeamProvider/raw/main/Images/ShareProject2.png)
