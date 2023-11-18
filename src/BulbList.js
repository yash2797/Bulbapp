// src/BulbList.js
import React, { useEffect, useState } from 'react';
import Bulb from './Bulb';
import axios from 'axios';

const BulbList = () => {
  const [bulbs, setBulbs] = useState([]);

  useEffect(() => {
    const fetchBulbs = async () => {
      try {
        const response = await axios.get('http://localhost:8080/bulbs');
        const bulbsInOrder = response.data.map(bulb => ({ ...bulb, isOn: false }));
        setBulbs(bulbsInOrder);
      } catch (error) {
        console.error('Error fetching bulbs:', error);
      }
    };

    fetchBulbs();
  }, []);

  const turnOnBulbsInOrder = async () => {
    // Helper function to turn on bulbs in the desired order
    const turnOnBulbs = async (startIdx, step) => {
      for (let i = startIdx; i < bulbs.length; i += step) {
        bulbs[i].isOn = true;
        setBulbs([...bulbs]); // Trigger a re-render
        await new Promise(resolve => setTimeout(resolve, 500)); // Delay for visibility
      }
    };

    await turnOnBulbs(0, 3);  // Turn on all Greens
    await turnOnBulbs(1, 3);  // Turn on all Reds
    await turnOnBulbs(2, 3);  // Turn on all Blues

    // Repeat the sequence (comment out if you want it to happen only once)
    await turnOnBulbs(0, 3);
    await turnOnBulbs(1, 3);
    await turnOnBulbs(2, 3);
  };

  return (
    <div>
      <button onClick={turnOnBulbsInOrder}>Turn On Bulbs</button>
      <div>
        {bulbs.map((bulb, index) => (
          <Bulb key={index} color={bulb.color} isOn={bulb.isOn} />
        ))}
      </div>
    </div>
  );
};

export default BulbList;
