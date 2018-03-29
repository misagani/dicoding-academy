using UnityEngine;
using UnityEngine.SceneManagement;

public class KendaliHalaman : MonoBehaviour 
{
    // parameter keluar
    public bool isEscapeToExit;
	
	// Update is called once per frame
	void Update () 
    {
        // tombol ESC untuk keluar
        if (Input.GetKeyUp(KeyCode.Escape))
        {
            if (isEscapeToExit)
            {
                Application.Quit();
            }
            else
            {
                KembaliKeMenu();
            }
        }		
	}

    // tombol mulai permainan
    public void MulaiPermainan()
    {
        SceneManager.LoadScene("Utama");
    }

    // tombol kembali ke menu awal
    public void KembaliKeMenu()
    {
        SceneManager.LoadScene("Pembuka");
    }
}
