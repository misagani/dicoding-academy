using UnityEngine;

public class Berputar : MonoBehaviour 
{
    // parameter kecepatan berputar
    public float kecepatan;

	// Update is called once per frame
	void Update () 
    {
        float gerak = kecepatan * Time.deltaTime;
        float nextPos = transform.rotation.z + gerak;	
        if (nextPos > 360)
        {
            gerak = 0;
        }
        transform.Rotate(0, 0, gerak);   
	}
}
