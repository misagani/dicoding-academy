using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PaddleController : MonoBehaviour 
{
	// speed dan axis
	public float kecepatan;
	public string axis;

	// limit atas bawah
	public float batasAtas;
	public float batasBawah;

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () 
	{
		float gerak = Input.GetAxis (axis) * kecepatan * Time.deltaTime;
		float nextPos = transform.position.y + gerak;
		if (nextPos > batasAtas) 
		{
			gerak = 0;
		}
		if (nextPos < batasBawah) 
		{
			gerak = 0;
		}
		transform.Translate (0, gerak, 0);
	}
}
