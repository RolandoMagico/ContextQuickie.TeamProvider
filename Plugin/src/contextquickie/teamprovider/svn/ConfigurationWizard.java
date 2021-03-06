package contextquickie.teamprovider.svn;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.core.TeamException;
import org.eclipse.team.ui.IConfigurationWizard;
import org.eclipse.ui.IWorkbench;

public class ConfigurationWizard extends Wizard implements IConfigurationWizard
{
  private SvnWizardPage wizardPage = new SvnWizardPage("Share Project: ");

  private  File workingCopyRoot;
  
  @Override
  public void addPages()
  {
    super.addPages();
    this.addPage(wizardPage);
  }

  @Override
  public boolean canFinish()
  {
    return (super.canFinish() && (this.workingCopyRoot != null));
  }

  private IProject currentProject;

  @Override
  public boolean performFinish()
  {
    boolean returnValue = false;
    if (workingCopyRoot != null)
    {
      try
      {
        RepositoryProvider.map(this.currentProject, SvnRepositoryProvider.class.getTypeName());
        returnValue = true;
      }
      catch (TeamException e)
      {
        e.printStackTrace();
        wizardPage.setErrorMessage(e.getMessage());
      }
    }

    return returnValue;
  }

  @Override
  public void init(IWorkbench workbench, IProject project)
  {
    this.currentProject = project;
   
    wizardPage.setProjectName(this.currentProject.getName());
    wizardPage.setProjectPath(this.currentProject.getLocation().toOSString());

    File currentDir = this.currentProject.getLocation().toFile();
    this.workingCopyRoot = new WorkingCopy(currentDir).getRoot();
    if (this.workingCopyRoot != null)
    {
      wizardPage.setWorkingCopy(workingCopyRoot.toString());
    }
    else
    {
      wizardPage.setErrorMessage("Unable to find the working copy root for project " + this.currentProject.getName());
    }
  }
}
