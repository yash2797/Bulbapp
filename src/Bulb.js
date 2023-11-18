// src/Bulb.js
import React from 'react';

const Bulb = ({ color, isOn }) => {
  const bulbStyle = {
    backgroundColor: isOn ? color.toLowerCase() : 'grey',
    width: '50px',
    height: '50px',
    borderRadius: '50%',
    display: 'inline-block',
    margin: '5px',
  };

  return <div style={bulbStyle}></div>;
};

export default Bulb;
