using UnityEngine;
using UnityEngine.UI;

public class KendaliBola : MonoBehaviour 
{
    // parameter global
    public int force;
    Rigidbody2D rigid;

    // parameter poin
    int poinP1;
    int poinP2;
    Text scoreUIP1;
    Text scoreUIP2;

    // parameter selesai
    GameObject panelSelesai;
    Text txPemenang; 

    // efek suara
    AudioSource audio;
    public AudioClip hitSound;

	// Use this for initialization
	void Start () 
    {
        rigid = GetComponent<Rigidbody2D>();
        Vector2 arah = new Vector2(2, 0).normalized;
        rigid.AddForce(arah * force);

        poinP1 = 0;
        poinP2 = 0;

        scoreUIP1 = GameObject.Find("Poin1").GetComponent<Text>();
        scoreUIP2 = GameObject.Find("Poin2").GetComponent<Text>();

        panelSelesai = GameObject.Find("PanelSelesai");
        panelSelesai.SetActive(false);

        audio = GetComponent<AudioSource>();
	}

    // reset
    void ResetBall()
    {
        transform.localPosition = new Vector2(0, 0);
        rigid.velocity = new Vector2(0, 0);
    }

    // on collision
    private void OnCollisionEnter2D(Collision2D coll)
    {
        // suara
        audio.PlayOneShot(hitSound);

        // collision pad ganti sudut
        if (coll.gameObject.name == "PadKiri" || coll.gameObject.name == "PadKanan")
        {
            float sudut = (transform.position.y - coll.transform.position.y) * 7f;
            Vector2 arah = new Vector2(rigid.velocity.x, sudut).normalized;
            rigid.velocity = new Vector2(0, 0);
            rigid.AddForce(arah * force * 2);
        }

        // collision kanan
        if (coll.gameObject.name == "BatasKanan")
        {
            poinP1 += 1;
            TampilkanPoin();
            ResetBall();
            Vector2 arah = new Vector2(2, 0).normalized;
            rigid.AddForce(arah * force);

            if (poinP1 == 3) 
            {
                panelSelesai.SetActive (true);
                txPemenang = GameObject.Find ("Pemenang").GetComponent<Text> ();
                txPemenang.text = "BIRU MENANG";
                Destroy (gameObject);
                return;
            } 
        }

        // collision kiri
        if (coll.gameObject.name == "BatasKiri")
        {
            poinP2 += 1;
            TampilkanPoin();
            ResetBall();
            Vector2 arah = new Vector2(-2, 0).normalized;
            rigid.AddForce(arah * force);

            if (poinP2 == 3) 
            {
                panelSelesai.SetActive (true);
                txPemenang = GameObject.Find ("Pemenang").GetComponent<Text> ();
                txPemenang.text = "HIJAU MENANG";
                Destroy (gameObject);
                return;
            } 
        }
    }

    // tampilkan visual poin
    void TampilkanPoin()
    {
        Debug.Log("Poin P1: " + poinP1 + " Poin P2: " + poinP2);
        scoreUIP1.text = poinP1 + "";
        scoreUIP2.text = poinP2 + "";
    }
}
