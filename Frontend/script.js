async function sendData() {
  const url = 'http://localhost:8080/user/signUp';
  
  const payload = {
     username:'gautam',
     password:'gautam123'
  };

  try {
    const response = await fetch(url, {
      method: 'POST', // Specifies the request type
      headers: {
        'Content-Type': 'application/json' // Informs the server of the data format
      },
      body: JSON.stringify(payload) // Converts JavaScript object to a JSON string
    });

    // Fetch does not automatically throw errors for 4xx or 5xx server statuses
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();
    const div=document.getElementById('div1');
    div.textContent=data?.data?.controllerData?.password; // Parses the JSON response body
    console.log('Success:', data );
  } catch (error) {
    console.error('Network or Server Error:', error);
  }
}

sendData();
